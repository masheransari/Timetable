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
public class Monday_B extends Fragment {
    Cards card,card1;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.comps_a_mon,container,false);

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
        card.addChild1("COA","10.00-11.00");
        card.addChild2("DBMS","11.00-12.00");
        card.addChild2("MATHS","12.00-1.00");
        card.addChild2("AOA","1.30-2.30");
        card.addChild2("CG","2.30-3.30");


        card1.addChild1("DBMS","B1 (601)");
        card1.addChild2("AOA","B2 (603)");
        card1.addChild2("COA","B3 (508)");
        card1.Subtitle("3.30 to 5.30");
        card1.changeHeader("Practicals");



        CardViewNative cardView = (CardViewNative)getActivity().findViewById(R.id.LectureCard);
        cardView.setCard(card);
        CardViewNative cardView2 = (CardViewNative)getActivity().findViewById(R.id.Pracs);
        cardView2.setCard(card1);

    }
}
