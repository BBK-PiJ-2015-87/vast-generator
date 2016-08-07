import com.famlabs.vast.ImpressionType;
import com.famlabs.vast.VAST;

public class VASTGenerator {
    public VAST generateSampleVAST() {
        VAST vast = new VAST();
        vast.setVersion("3.0");

        VAST.Ad ad = new VAST.Ad();
        VAST.Ad.InLine inLine = new VAST.Ad.InLine();
        VAST.Ad.InLine.Creatives creatives = new VAST.Ad.InLine.Creatives();
        VAST.Ad.InLine.Creatives.Creative creative = new VAST.Ad.InLine.Creatives.Creative();

        inLine.getImpression().add(new ImpressionType());
        creatives.getCreative().add(creative);
        inLine.setCreatives(creatives);
        ad.setInLine(inLine);

        vast.getAd().add(ad);

        return vast;
    }
}
