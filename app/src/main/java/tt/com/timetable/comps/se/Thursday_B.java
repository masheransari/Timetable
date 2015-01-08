package tt.com.timetable.comps.se;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import it.gmariotti.cardslib.library.view.CardViewNative;
import tt.com.timetable.Cards;
import tt.com.timetable.R;

/**
 * Created by aditockzz on 02-Jan-15.
 */
public class Thursday_B extends Fragment {
    Cards card1,card;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.comps_a_thurs,container,false);

    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        iniCard();
    }

    private void iniCard() {
        card = new Cards(getActivity());
        card1  = new Cards(getActivity());
        card.init();
        card1.init();

        card.changeHeader("Lectures");
        card.Subtitle("10.00 to 3.30");
        card.addChild1("AOA","10.00-11.00");
        card.addChild2("TCS","11.00-12.00");
        card.addChild2("MATHS","12.00-1.00");
        card.addChild2("DBMS","1.30-2.30");
        card.addChild2("COA","2.30-3.30");


        card1.addChild1("AOA","B1 (603)");
        card1.addChild2("CG","B2 (503)");
        card1.addChild2("DBMS","B4 (601)");
        card1.Subtitle("3.30 to 5.30");
        card1.changeHeader("Practicals");



        CardViewNative cardView = (CardViewNative)getActivity().findViewById(R.id.LectureCard4);
        cardView.setCard(card);
        CardViewNative cardView2 = (CardViewNative)getActivity().findViewById(R.id.pracs4);
        cardView2.setCard(card1);

    }
}
