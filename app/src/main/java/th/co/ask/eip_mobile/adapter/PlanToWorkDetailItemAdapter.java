package th.co.ask.eip_mobile.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import th.co.ask.eip_mobile.dao.ListPlanToWorkTodoDetailDao;
import th.co.ask.eip_mobile.view.LoadMoreViewGroup;
import th.co.ask.eip_mobile.view.PlanToWorkDetailItemViewGroup;

/**
 * Created by nitiwat.li on 17/03/2559.
 */
public class PlanToWorkDetailItemAdapter extends RecyclerView.Adapter {
    private Context context;
    private static List<ListPlanToWorkTodoDetailDao> listPlanToWorkTodoDetailDaos;
    private static OnItemClickListener listener;
    private int VIEW_ITEM = 0;
    private int VIEW_PROG = 1;

    public interface OnItemClickListener {
        void onDetailItemClick(View itemView, int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public PlanToWorkDetailItemAdapter(Context context, List<ListPlanToWorkTodoDetailDao> listPlanToWorkTodoDetailDaos) {
        this.context = context;
        this.listPlanToWorkTodoDetailDaos = listPlanToWorkTodoDetailDaos;
    }

    @Override
    public int getItemViewType(int position) {
        return listPlanToWorkTodoDetailDaos.size() != 0 ? VIEW_ITEM : VIEW_PROG;
    }

    public void updateNewData(List<ListPlanToWorkTodoDetailDao> newListPlanToWorkTodoDetailDaos) {

    }

    public void inseartNewData(List<ListPlanToWorkTodoDetailDao> newListPlanToWorkTodoDetailDaos) {

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        if (viewType == VIEW_ITEM) {
            view = new PlanToWorkDetailItemViewGroup(parent.getContext());
            view.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT));
        }else if (viewType == VIEW_PROG) {
            view = new LoadMoreViewGroup(parent.getContext());
        }

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder.getItemViewType() == VIEW_ITEM) {
            ListPlanToWorkTodoDetailDao listPlanToWorkTodoDetailDao = listPlanToWorkTodoDetailDaos.get(position);
            ((PlanToWorkDetailItemViewGroup) ((ViewHolder) holder).itemView).setTextData(listPlanToWorkTodoDetailDao.getCustName(),
                    listPlanToWorkTodoDetailDao.getCustCardNo(), listPlanToWorkTodoDetailDao.getSaleCallNo());
        }

    }

    @Override
    public int getItemCount() {
        return listPlanToWorkTodoDetailDaos.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(final View itemView) {
            super(itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null)
                        listener.onDetailItemClick(itemView, getLayoutPosition());
                }
            });

        }
    }
}
