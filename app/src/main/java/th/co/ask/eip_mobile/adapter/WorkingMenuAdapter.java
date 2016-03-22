package th.co.ask.eip_mobile.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import th.co.ask.eip_mobile.view.WorkingMenuViewGroup;

/**
 * Created by nitiwat.li on 17/03/2559.
 */
public class WorkingMenuAdapter extends RecyclerView.Adapter {

    private static OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(View itemView, int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public WorkingMenuAdapter() {
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(new WorkingMenuViewGroup(parent.getContext()));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (position % 4 == 0) {
            ((WorkingMenuViewGroup) ((ViewHolder) holder).itemView).setTextTitle("APPLY HP");
            ((WorkingMenuViewGroup) ((ViewHolder) holder).itemView).setTextDescription("You can work feature Apply Hire Purchase ");
        } else if (position % 4 == 1) {
            ((WorkingMenuViewGroup) ((ViewHolder) holder).itemView).setTextTitle("SALE CALL");
            ((WorkingMenuViewGroup) ((ViewHolder) holder).itemView).setTextDescription("Create your sale call and management your time here.");
        } else if (position % 4 == 2) {
            ((WorkingMenuViewGroup) ((ViewHolder) holder).itemView).setTextTitle("FUNDING");
            ((WorkingMenuViewGroup) ((ViewHolder) holder).itemView).setTextDescription("Work with funding. ");
        } else if (position % 4 == 3) {
            ((WorkingMenuViewGroup) ((ViewHolder) holder).itemView).setTextTitle("STEP PAYMENT CALCULATE");
            ((WorkingMenuViewGroup) ((ViewHolder) holder).itemView).setTextDescription("Manage your step payment ");
        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(final View itemView) {
            super(itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null)
                        listener.onItemClick(itemView, getLayoutPosition());
                }
            });
        }
    }
}
