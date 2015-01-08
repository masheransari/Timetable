package tt.com.timetable.comps.te;

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
 * Created by aditockzz on 23-Dec-14.
 */
public class Wednesday extends Fragment {
    Cards card,card1,card2;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.te_wed,container,false);

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
        card2.init();
        card.init();
        card1.init();

        card.changeHeader("Lectures");
        card.Subtitle("1.30 to 5.30");
        card.addChild1("PM","1.30-2.30");
        card.addChild2("DDBMS","2.30- 3.30");
        card.addChild2("SE","3.30-4.30");
        card.addChild2("SPCC","4.30-5.30");

        card1.changeHeader("Practicals");
        card1.Subtitle("9.00 to 11.00");
        card1.addChild1("NW"," A3 (601)");
        card1.addChild2("DDBMS"," A2 (507)");

        card2.changeHeader("");
        card2.Subtitle("11.00 to 1.00");
        card2.addChild1("SPCC","A1 (401)");
        card2.addChild2("SE","A2 (501)");
        card2.addChild2("NW","A3 (601)");
        card2.addChild2("MC","A4 (507)");



        CardViewNative cardView = (CardViewNative)getActivity().findViewById(R.id.te_LectureCard3);
        cardView.setCard(card);
        CardViewNative cardView1 = (CardViewNative)getActivity().findViewById(R.id.Pracs3a);
        cardView1.setCard(card1);
        CardViewNative cardView2 = (CardViewNative)getActivity().findViewById(R.id.Pracs3b);
        cardView2.setCard(card2);
    }
}
