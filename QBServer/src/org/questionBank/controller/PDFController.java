package org.questionBank.controller;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.List;

import org.questionBank.dao.CourseDataUtil;
import org.questionBank.dao.QuestionDataUtil;
import org.questionBank.data.Course;
import org.questionBank.data.Question;
import org.questionBank.pdf.QuestionairePDFGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.itextpdf.text.DocumentException;

@RestController
public class PDFController {

	@Autowired
	CourseDataUtil courseDAO;
	@Autowired
	QuestionDataUtil questionDAO;

	@RequestMapping(value="/PrintCourseQuestionsView", method=RequestMethod.GET)
	public ModelAndView viewCoursePDFGenerator(@RequestParam("courseId") int courseId){
		ModelAndView mve = null;
		mve = new ModelAndView("views/pdf/GenerateCoursePDF");
		
		Course c = courseDAO.findCourse(courseId);
		mve.addObject("course", c);
		
		return mve;
	}

	@RequestMapping(value="/CreateCourseQuestionSheet", method=RequestMethod.POST)
	public ModelAndView createCourseQuestionSheet(@RequestParam(required=true) int courseId, @RequestParam(required=false) String pdfTitle, @RequestParam(required=false) boolean includeAnswers){
		ModelAndView mve = null;
		
		Course c = courseDAO.findCourse(courseId);
		List<Question> questions = questionDAO.getQuestionsForCourse(c);
		String title = pdfTitle; 
		if(title == null || title.trim().isEmpty()){
			title = getCourseTitle(c);
		}
		File file = null;
		QuestionairePDFGenerator pdfGen = new QuestionairePDFGenerator();
		try{
			if(includeAnswers){
				file = pdfGen.createQAndAPdfForQuestions(title, questions);
			}else{
				file = pdfGen.createQuestionPDFForQuestions(title, questions);
			}
	        Desktop.getDesktop().open(file);
		}catch(IOException ex){
			mve = new ModelAndView("redirect:/PrintCourseQuestionsView");
			mve.addObject("courseId", courseId);
			mve.addObject("errors", "Error creating PDF File");
			return mve;
		}catch(DocumentException ex){
			mve = new ModelAndView("redirect:/PrintCourseQuestionsView");
			mve.addObject("courseId", courseId);
			mve.addObject("errors", "Error creating PDF Document");
			return mve;
		}
		mve = new ModelAndView("redirect:/ShowCourse");
		mve.addObject("id", courseId);

		return mve;
	}

    private String getCourseTitle(Course course){
    	String title = course.getCourseName();
    	return title;
    }
    
}
