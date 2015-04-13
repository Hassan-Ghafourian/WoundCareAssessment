package utilities.generators;

import java.util.ArrayList;

import com.sina.pars.woundcareassessment.model.constants.enums.data.WoundSite;
import com.sina.pars.woundcareassessment.model.data.bradenassessment.BradenAssessment;
import com.sina.pars.woundcareassessment.model.data.present.doc.WoundDoc;
import com.sina.pars.woundcareassessment.model.data.present.paper.WoundPaper;

public class WoundDocList {
	public static ArrayList<WoundDoc> generate(ArrayList<WoundPaper> woundPaperList) {
		ArrayList<WoundDoc> woundDocList = new ArrayList<WoundDoc>();
		BradenAssessment bradenAssessment = new BradenAssessment.Builder().build();
		woundDocList.add(new WoundDoc.Builder(bradenAssessment, WoundSite.ARM, woundPaperList).build());
		woundDocList.add(new WoundDoc.Builder(bradenAssessment, WoundSite.NECK, woundPaperList).build());
		return woundDocList;
	}
}
