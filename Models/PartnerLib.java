package io.github.ashleysullins.breakthecode.Models;

import java.lang.reflect.Array;
import java.util.ArrayList;

import io.github.ashleysullins.breakthecode.R;

/**
 * Created by ashleysullins on 10/21/15.
 */
public class PartnerLib {
    private ArrayList<Partner> mPartners;

    public PartnerLib() {
        setNonProfitPartners();
    }

    public ArrayList<Partner> getPartners() {
        return mPartners;
    }

    private void setNonProfitPartners() {
        mPartners = new ArrayList<>();

        mPartners.add(new Partner(
                "App Camp for Girls",
                "App Camp For Girls is a place where girls can put their creative powers to work, designing and building apps, while learning more about the business of software and being inspired by women mentors in the field.",
                "http://appcamp4girls.com/",
                R.drawable.app_camp_for_girls
        ));

        mPartners.add(new Partner(
                "Chicktech",
                "We facilitate hands-on technology-centric events to empower, support, and increase the confidence of women and girls.  Through our events, we build community, empower participants to see themselves as leaders, and provide networking and mentoring opportunities in the rapidly growing high tech industry.",
                "http://chicktech.org/",
                R.drawable.chicktech
        ));

        mPartners.add(new Partner(
                "Girl Develop It!",
                "Girl Develop It is a nonprofit organization that provides affordable programs for adult women interested in learning web and software development in a judgment-free environment.",
                "https://www.girldevelopit.com/chapters/portland",
                R.drawable.girl_develop_it
        ));
    }

    public Partner nextPartner(Partner currentPartner) {
        int index = mPartners.indexOf(currentPartner);
        if (index == mPartners.size() - 1) {
            return mPartners.get(0);
        } else {
            return mPartners.get(index + 1);
        }
    }
}
