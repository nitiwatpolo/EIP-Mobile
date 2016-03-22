package th.co.ask.eip_mobile.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import th.co.ask.eip_mobile.view.OptionMenuViewGroup;

/**
 * Created by nitiwat.li on 17/03/2559.
 */
public class OptionMenuAdapter extends RecyclerView.Adapter {
    private String[] arrMenu;
    private static OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(View itemView, int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public OptionMenuAdapter(String[] arrMenu) {
        this.arrMenu = arrMenu;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(new OptionMenuViewGroup(parent.getContext()));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((OptionMenuViewGroup) ((ViewHolder) holder).itemView).setTextTitle(arrMenu[position]);
    }

    @Override
    public int getItemCount() {
        return arrMenu.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(final View itemView) {
            super(itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener!=null)
                        listener.onItemClick(itemView,getLayoutPosition());
                }
            });
        }
    }
}
