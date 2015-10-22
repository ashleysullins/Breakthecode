package io.github.ashleysullins.breakthecode.UI;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import io.github.ashleysullins.breakthecode.Models.Partner;
import io.github.ashleysullins.breakthecode.Models.PartnerLib;
import io.github.ashleysullins.breakthecode.R;

public class NonProfitActivity extends AppCompatActivity {

    private TextView mNameLabel;
    private TextView mDescriptionLabel;
    private ImageView mPartnerImage;
    private Button mNextButton;

    private PartnerLib mPartnerLib;
    private Partner mCurrentPartner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_non_profit);

        mNameLabel = (TextView) findViewById(R.id.nameLabel);
        mDescriptionLabel = (TextView) findViewById(R.id.descriptionLabel);
        mPartnerImage = (ImageView) findViewById(R.id.partnerImage);
        mNextButton = (Button) findViewById(R.id.nextButton);
        mPartnerLib = new PartnerLib();
        mCurrentPartner = mPartnerLib.getPartners().get(0);

        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentPartner = mPartnerLib.nextPartner(mCurrentPartner);
                setLayoutContent();
            }
        });

        mPartnerImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(mCurrentPartner.getWebsite()));
                startActivity(intent);
            }
        });
    }

    private void setLayoutContent() {
        mNameLabel.setText(mCurrentPartner.getName());
        mDescriptionLabel.setText(mCurrentPartner.getDescription());
        mPartnerImage.setImageResource(mCurrentPartner.getImage());
    }

}
