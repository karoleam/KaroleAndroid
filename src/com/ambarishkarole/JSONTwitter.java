package com.ambarishkarole;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class JSONTwitter extends Activity {

	private TextView httpLoadingData;
	private HttpClient httpClient;
	private JSONObject json;

	private final static String URL = "http://api.twitter.com/1/statuses/user_timeline.json?screen_name=";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.httpexample);
		httpLoadingData = (TextView) findViewById(R.id.tvHttpLoadingData);
		httpClient = new DefaultHttpClient();
		new Read().execute("text");
	}

	public JSONObject lastTweet(String userName)
			throws ClientProtocolException, IOException, JSONException {

		StringBuilder url = new StringBuilder(URL);
		url.append(userName);

		HttpGet get = new HttpGet(url.toString());
		HttpResponse response = httpClient.execute(get);
		int status = response.getStatusLine().getStatusCode();
		if (status == 200) {
			HttpEntity e = response.getEntity();
			String data = EntityUtils.toString(e);
			JSONArray timeline = new JSONArray(data);
			JSONObject lastTweet = timeline.getJSONObject(0);
			return lastTweet;
		} else {
			Toast.makeText(JSONTwitter.this, "error", Toast.LENGTH_SHORT);
			return null;
		}

	}

	public class Read extends AsyncTask<String, Integer, String> {

		@Override
		protected String doInBackground(String... params) {
			try {
				json = lastTweet("karoleam");
				return json.getString(params[0]);
			} catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}

		@Override
		protected void onPostExecute(String result) {
			httpLoadingData.setText(result);
		}

	}


}