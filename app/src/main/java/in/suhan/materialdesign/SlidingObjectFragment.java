package in.suhan.materialdesign;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SlidingObjectFragment# newInstance} factory method to
 * create an instance of this fragment.
 */
public class SlidingObjectFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sliding_object, container, false);

        ((TextView)view.findViewById(R.id.slide_body_text)).setText("Hello World");
        // Inflate the layout for this fragment
        return view;
    }


}
