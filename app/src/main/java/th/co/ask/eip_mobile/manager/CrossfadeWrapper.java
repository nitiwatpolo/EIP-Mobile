package th.co.ask.eip_mobile.manager;

import com.mikepenz.crossfader.Crossfader;
import com.mikepenz.materialdrawer.interfaces.ICrossfader;

/**
 * Created by nitiwat.li on 25/03/2559.
 */
public class CrossfadeWrapper implements ICrossfader {
    private Crossfader mCrossfader;

    public CrossfadeWrapper(Crossfader crossfader) {
        this.mCrossfader = crossfader;
    }

    @Override
    public void crossfade() {
        mCrossfader.crossFade();
    }

    @Override
    public boolean isCrossfaded() {
        return mCrossfader.isCrossFaded();
    }
}
