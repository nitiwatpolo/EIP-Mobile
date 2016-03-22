package th.co.ask.eip_mobile.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import th.co.ask.eip_mobile.R;
import th.co.ask.eip_mobile.dao.ListPlanDao;
import th.co.ask.eip_mobile.dao.PlanByDateDao;
import th.co.ask.eip_mobile.view.ItemEmptyViewGroup;
import th.co.ask.eip_mobile.view.OptionMenuViewGroup;
import th.co.ask.eip_mobile.view.PlanByDateItemViewGroup;

/**
 * Created by nitiwat.li on 17/03/2559.
 */
public class PlanByDateItemAdapter extends RecyclerView.Adapter {
    private Context context;
    private static List<ListPlanDao> listPlanDaos;
    private static OnItemClickListener listener;
    public final int TYPE_VIEW_EMPTY = 0;
    public final int TYPE_VIEW_LIST = 1;

    public interface OnItemClickListener {
        void onItemClick(View itemView, int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public PlanByDateItemAdapter(Context context, List<ListPlanDao> listPlanDaos) {
        this.context = context;
        this.listPlanDaos = listPlanDaos;
    }

    @Override
    public int getItemViewType(int position) {
        if (listPlanDaos.size() == 0) {
            return TYPE_VIEW_EMPTY;
        } else {
            return TYPE_VIEW_LIST;
        }

    }

    public void updateNewData(List<ListPlanDao> newListPlanDaos) {
        listPlanDaos.clear();
        listPlanDaos.addAll(newListPlanDaos);
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        if (viewType == TYPE_VIEW_EMPTY) {
            view = new ItemEmptyViewGroup(parent.getContext());
        } else {
            view = new PlanByDateItemViewGroup(parent.getContext());
        }
        view.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT));

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder.getItemViewType() == TYPE_VIEW_EMPTY) {
            ((ItemEmptyViewGroup) ((ViewHolder) holder).itemView)
                    .setTextEmpty(context.getResources().getString(R.string.fragment_work_plan_item_not_found_en));

        } else {
            ListPlanDao listPlanDao = listPlanDaos.get(position);
            ((PlanByDateItemViewGroup) ((ViewHolder) holder).itemView).setTextData(listPlanDao.getTitle(),
                    listPlanDao.getSaleCallNo(), listPlanDao.getTodoName(),
                    listPlanDao.getNote());
        }
    }

    @Override
    public int getItemCount() {
        return listPlanDaos.size() > 0 ? listPlanDaos.size() : 1;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(final View itemView) {
            super(itemView);

            if (listPlanDaos.size() > 0) {
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
}
