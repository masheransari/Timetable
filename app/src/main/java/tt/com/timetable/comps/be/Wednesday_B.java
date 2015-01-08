package tt.com.timetable.comps.be;

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
public class Wednesday_B extends Fragment {
    Cards card1,card;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.comps_a_wed,container,false);

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
        card.Subtitle("10.00 to 1.00 & 3.30-4.30");
        card.addChild1("DC","10.00-11.00");
        card.addChild2("CV","11.00-12.00");
        card.addChild2("MSD","12.00-1.00");
        card.addChild2("SA","3.30-4.30");


        card1.addChild1("MSD","B1 (603)");
        card1.addChild2("SA","B2 (508)");
        card1.addChild2("CV","B3 (402)");
        card1.addChild2("DC","B4 (501)");
        card1.Subtitle("1.30 to 3.30");
        card1.changeHeader("Practicals");



        CardViewNative cardView = (CardViewNative)getActivity().findViewById(R.id.LectureCard3);
        cardView.setCard(card);
        CardViewNative cardView2 = (CardViewNative)getActivity().findViewById(R.id.pracs3);
        cardView2.setCard(card1);

    }

}
