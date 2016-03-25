package th.co.ask.eip_mobile.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import th.co.ask.eip_mobile.R;
import th.co.ask.eip_mobile.dao.ListPlanToWorkTodoTaskDao;
import th.co.ask.eip_mobile.view.PlanToWorkTaskItemViewGroup;

/**
 * Created by nitiwat.li on 17/03/2559.
 */
public class PlanToWorkTaskItemAdapter extends RecyclerView.Adapter {
    private Context context;
    private static List<ListPlanToWorkTodoTaskDao> listPlanToWorkTodoTaskDaos;
    private static OnItemClickListener listener;

    public interface OnItemClickListener {
        void onTaskItemClick(View itemView, int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public PlanToWorkTaskItemAdapter(Context context, List<ListPlanToWorkTodoTaskDao> listPlanToWorkTodoTaskDaos) {
        this.context = context;
        this.listPlanToWorkTodoTaskDaos = listPlanToWorkTodoTaskDaos;
    }


    public void updateNewData(List<ListPlanToWorkTodoTaskDao> newListPlanToWorkTodoTaskDaos) {
        listPlanToWorkTodoTaskDaos.clear();
        listPlanToWorkTodoTaskDaos.addAll(newListPlanToWorkTodoTaskDaos);
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = new PlanToWorkTaskItemViewGroup(parent.getContext());
        view.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT));

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ListPlanToWorkTodoTaskDao listPlanToWorkTodoTaskDao = listPlanToWorkTodoTaskDaos.get(position);
        ((PlanToWorkTaskItemViewGroup) ((ViewHolder) holder).itemView).setTextData(listPlanToWorkTodoTaskDao.getTodoName(),
                listPlanToWorkTodoTaskDao.getNum());
    }

    @Override
    public int getItemCount() {
        return listPlanToWorkTodoTaskDaos.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(final View itemView) {
            super(itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null)
                        listener.onTaskItemClick(itemView, getLayoutPosition());
                }
            });

        }
    }
}
