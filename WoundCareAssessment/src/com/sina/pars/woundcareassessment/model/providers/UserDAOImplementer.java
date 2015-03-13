package com.sina.pars.woundcareassessment.model.providers;

import android.content.ContentProviderClient;
import android.database.Cursor;
import android.net.Uri;
import android.os.RemoteException;

import com.sina.pars.woundcareassessment.application.App;
import com.sina.pars.woundcareassessment.model.data.person.User;

/**
 * <b>Singleton</b> class,because one instance of this class can respond to all
 * responsibilities of this class in any time and any where.
 * 
 * @author Arpa930424
 * 
 */
public class UserDAOImplementer implements UserDAO {

	/**
	 * A direct link to the <b>LocalUserProvide</b><br/>
	 * UserDAOImplementer works only by "LocalUserProvide",so we use
	 * "providerClient" statically
	 */
	private static ContentProviderClient providerClient;
	private static final UserDAOImplementer INSTANCE = new UserDAOImplementer();

	private UserDAOImplementer() {
		initProviderClient();
	}

	@Override
	public int delete(UserDAOMethodsInput userDAOMethodsInput) {

		return 0;
	}

	@Override
	public Uri insert(UserDAOMethodsInput userDAOMethodsInput) {
		return null;
	}

	@Override
	public Cursor query(UserDAOMethodsInput userDAOMethodsInput) {
		switch (userDAOMethodsInput.getEffectDestinationType()) {
		case LOCAL:
			try {
				return providerClient.query(
						buildUriFromUserDAOMethodsInputContent(userDAOMethodsInput), null,
						null, null, null);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		case REMOTE:
			break;

		default:
			throw new IllegalArgumentException(userDAOMethodsInput
					.getEffectDestinationType().toString()
					+ "is not legal.It must be REMOTE or LOCAL");
		}
		return null;
	}

	@Override
	public int update(UserDAOMethodsInput userDAOMethodsInput) {

		return 0;
	}

	private static void initProviderClient() {
		if (providerClient == null) {
			providerClient = App
					.getAppContext()
					.getContentResolver()
					.acquireContentProviderClient(
							LocalUserProviderMetaData.AUTHORITY);
		}
	}

	public static UserDAOImplementer getInstance() {
		return INSTANCE;
	}

	/**
	 * builds uri of associated <b>single local</b> data from userDAOMethodsInput's
	 * content.<br/>
	 * uri will be combine of Authority of LocalUserProvider,path of
	 * LocalUserTable and userName.
	 * 
	 * @param userDAOMethodsInput
	 * @return
	 */
	private Uri buildUriFromUserDAOMethodsInputContent(
			UserDAOMethodsInput userDAOMethodsInput) {
		String userName = userDAOMethodsInput.getUserName();
		return Uri
				.parse(LocalUserProviderMetaData.LocalUserTableMetaData.CONTENT_URI
						+ userName);
	}

	@Override
	public User sync(UserDAOMethodsInput userDAOMethodsInput) {
		// TODO Auto-generated method stub
		return null;
	}
}
