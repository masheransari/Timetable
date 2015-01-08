package tt.com.timetable.comps.te;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toolbar;

import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.prototypes.CardWithList;
import it.gmariotti.cardslib.library.view.CardViewNative;
import tt.com.timetable.*;


public class Monday extends Fragment {
      Cards card,card1,card2;


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.te_mon,container,false);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
       iniCard();
    }

    private void iniCard() {
        card = new Cards(getActivity());
        card1  = new Cards(getActivity());
        card2 = new Cards(getActivity());

        card.init();
        card1.init();
        card2.init();

        card.changeHeader("Lectures");
        card.Subtitle("1.30 to 4.30");
        card.addChild1("PM","1.30-2.30");
        card.addChild2("SPCC","2.30- 3.30");
        card.addChild2("MC","3.30-4.30");

        card1.changeHeader("Practicals");
        card1.Subtitle("9.00 to 11.00");
        card1.addChild1("NW"," A1 (601)");
        card1.addChild2("PM"," A4 (401)");

        card2.changeHeader("");
        card2.Subtitle("11.00 to 1.00");
        card2.addChild1("NW","A1 (601)");
        card2.addChild2("MC","A2 (507)");
        card2.addChild2("SPCC","A3 (401)");
        card2.addChild2("SE","A4 (501)");


        CardViewNative cardView = (CardViewNative)getActivity().findViewById(R.id.te_LectureCard1);
        cardView.setCard(card);
        CardViewNative cardView1 = (CardViewNative)getActivity().findViewById(R.id.Pracs1a);
        cardView1.setCard(card1);
        CardViewNative cardView2 = (CardViewNative)getActivity().findViewById(R.id.Pracs1b);
        cardView2.setCard(card2);



    }


}
