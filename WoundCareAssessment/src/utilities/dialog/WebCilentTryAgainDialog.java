package utilities.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;

import com.sina.pars.woundcareassessment.model.network.web.response.ServerResponse;

public class WebCilentTryAgainDialog {
	public static void setListenersAndShow(Context context, ServerResponse response){
		final Context finalContext = context;
		final ServerResponse finalResponse = response;
		if(!implementsInterface(finalContext, Alertable.class)){
			throw new IllegalArgumentException("context must implement Alertable interface.");
		}
		AlertDialog.Builder builder = new AlertDialog.Builder(finalContext);
		builder.setMessage(finalResponse.getStatus() + ",do you want to try Again?");
		builder.setPositiveButton("Yes", new Dialog.OnClickListener() {

		    @Override
		    public void onClick(DialogInterface dialog, int which) { 
		        ((Alertable)finalContext).onAlert(finalResponse, TryAgainResult.YES);
		        dialog.cancel();
		    }

		});

		builder.setNegativeButton("No", new Dialog.OnClickListener() {

		    @Override
		    public void onClick(DialogInterface dialog, int which) {
		    	((Alertable)finalContext).onAlert(finalResponse, TryAgainResult.NO);
		        dialog.cancel();

		    }

		});

		builder.show();
	}
	
	private static boolean implementsInterface(Object object, Class interf){
	    return interf.isInstance(object);
	}
}
