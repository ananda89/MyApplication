package com.example.mujahid.allinall.Fragment;


import android.Manifest;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mujahid.allinall.Activity.L;
import com.example.mujahid.allinall.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * A simple {@link Fragment} subclass.
 */
public class AsynTask extends Fragment {
    ProgressBar progressBar;
    EditText editText;
    LinearLayout loading;
    Button button;
    TextView downloading;

    public AsynTask() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},122);
        ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.INTERNET},123);
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_asyn_task, container, false);
    }


    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if(getView()!=null){
            progressBar = getView().findViewById(R.id.progressBar);
            editText = getView().findViewById(R.id.text);
            downloading = getView().findViewById(R.id.downloading);
            loading = getView().findViewById(R.id.loading);
            button = getView().findViewById(R.id.downbutton);
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
        new MyTask().execute(editText.getText().toString());
            }
        });



        ListView listView = getView().findViewById(R.id.list_item);
        final String[] listofImages = {"Image 1","Image 2", "Image 3", "Image 4"};
        final String[] listofURL = getResources().getStringArray(R.array.image);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,listofImages);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                switch (position){
                    case 0:
                        editText.setText(listofURL[position]);
                    case 1:
                        editText.setText(listofURL[position]);
                    case 2:
                        editText.setText(listofURL[position]);
                    case 3:
                        editText.setText(listofURL[position]);
                }
            }
        });
    }

    class MyTask extends AsyncTask<String, Integer, Boolean>{

        protected void onPreExecute(){
        loading.setVisibility(View.VISIBLE);
        }
        @Override
        protected Boolean doInBackground(String... voids) {
            boolean successful = false;
            URL downlaodurl = null;
            HttpURLConnection connection = null;
            InputStream inputStream = null;
            FileOutputStream outputStream = null;
            File file = null;
            try {
                downlaodurl = new URL(voids[0]);
                try {
                    connection = (HttpURLConnection) downlaodurl.openConnection();

                    //needed math is (file downloaded * 100 / file size need to publish this progress to progressbar
                    inputStream = connection.getInputStream();
                    int fileSize = connection.getContentLength();
                    file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getAbsolutePath()
                            + "/" + Uri.parse(voids[0]).getLastPathSegment());
                    outputStream = new FileOutputStream(file);
                    int read = -1;
                    byte[] buffer = new byte[1024];
                    int sum = 0;
                    while((read = inputStream.read(buffer))!=-1){

                        outputStream.write(buffer, 0, read);

                        sum = sum + read;
                        if(fileSize>0){
                            publishProgress((int) (sum * 100 / fileSize));
                        }

                        L.m(String.format("the summation is %d and the percent is %d",sum,sum * 100 / fileSize));
                        L.m(String.format("%d",read));
                    }
                    successful = true;



                } catch (IOException e) {
                    L.m(e+"");
                }
            } catch (MalformedURLException e) {
                L.m(e+"");
            }

            finally {


                if(connection!=null){
                    connection.disconnect();
                }
                if(inputStream!=null){
                    try {

                        inputStream.close();

                    } catch (IOException e) {
                        L.m(e+"");
                    }
                    if(outputStream!=null){
                        try {
                            outputStream.close();
                        } catch (IOException e) {
                            L.m(e+"");
                        }
                    }
                }
            }
return null;
        }

        protected void onProgressUpdate(Integer...data){
            progressBar.setIndeterminate(false);
            progressBar.setMax(100);
progressBar.setProgress(data[0]);
downloading.setText(String.format("%d%% downloading", data[0] ));
        }

        protected void onPostExecute(Boolean result){
            loading.setVisibility(View.GONE);
            Toast.makeText(getActivity(),"Download Complete", Toast.LENGTH_LONG).show();
            progressBar.setProgress(0);

        }

    }

}
