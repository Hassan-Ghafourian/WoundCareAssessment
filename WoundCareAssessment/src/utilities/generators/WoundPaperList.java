package utilities.generators;

import java.util.ArrayList;

import com.sina.pars.woundcareassessment.model.data.present.comment.Comment;
import com.sina.pars.woundcareassessment.model.data.present.paper.WoundPaper;

public class WoundPaperList {
	public static ArrayList<WoundPaper> generate(ArrayList<Comment> commentList) {
		ArrayList<WoundPaper> paperList = new ArrayList<WoundPaper>();
		String imageUri = "some URI";
		paperList.add(new WoundPaper.Builder(imageUri, commentList).build());
		paperList.add(new WoundPaper.Builder(imageUri, commentList).build());
//		paperList.add(new WoundPaper.Builder(imageUri, commentList).build());
//		paperList.add(new WoundPaper.Builder(imageUri, commentList).build());
//		paperList.add(new WoundPaper.Builder(imageUri, commentList).build());
		return paperList;
	}
}
