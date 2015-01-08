package tt.com.timetable;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.CardHeader;
import it.gmariotti.cardslib.library.prototypes.CardWithList;

public class CardsTE extends CardWithList {
    CardHeader header;
    // String lec,batch;
    List<ListObject> mObjects  = new ArrayList<>();
    TextView lec;
    TextView time;
    TextView subtitle;
    String str;
    public CardsTE(Context context)
    {
        super(context);
    }

    @Override
    protected CardHeader initCardHeader() {

        header = new CardHeader(getContext(), R.layout.header) {

            @Override
            public void setupInnerViewElements(ViewGroup parent, View view) {
                super.setupInnerViewElements(parent, view);
                subtitle = (TextView)view.findViewById(R.id.subtitle);
                if(subtitle!=null)
                    subtitle.setText(str);

            }
        };
        header.setTitle("");
        return header;

    }

    @Override
    protected void initCard() {
    }

    @Override
    public List<ListObject> initChildren() {

        return mObjects;
    }

    @Override
    public View setupChildView(int i, ListObject listObject, View view, ViewGroup viewGroup) {

        lec = (TextView)view.findViewById(R.id.lec);
        time  = (TextView)view.findViewById(R.id.time);

        Objects objs = (Objects)listObject;
        lec.setText(objs.lec);
        time.setText(objs.time);

        return view;
    }

    @Override
    public int getChildLayoutId() {

        return R.layout.cards;
    }

    public  class  Objects extends DefaultListObject
    {
        public String lec;
        public String time;
        public String batch ;

        public Objects(Card parent)
        {
            super(parent);
        }


    }
    public void changeHeader(String headers)
    {
        header.setTitle(headers);
    }

    public List<ListObject>addChild1(String  lec,String batch) {

        mObjects.removeAll(mObjects);

        Objects batchs = new Objects(this);
        batchs.lec = lec;
        batchs.time = batch;
        mObjects.add(batchs);


        return mObjects;
    }
    public List<ListObject>addChild2(String  lec,String batch) {

        Objects batchs = new Objects(this);
        batchs.lec = lec;
        batchs.time = batch;
        mObjects.add(batchs);

        return mObjects;
    }

    public void Subtitle(String sub)
    {
        str = sub;
    }

}
