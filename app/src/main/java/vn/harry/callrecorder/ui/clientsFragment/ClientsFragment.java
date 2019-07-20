package vn.harry.callrecorder.ui.clientsFragment;

import android.annotation.SuppressLint;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import vn.harry.callrecorder.ServiceCall.OnServiceCallResponse;
import vn.harry.callrecorder.ServiceCall.ServiceCallUtils;
import vn.harry.callrecorder.adapter.ClientsAdapter;
import vn.harry.callrecorder.entity.MessageEvent;
import vn.harry.callrecorder.entity.Recording;
import vn.harry.callrecorder.response.ClientList.ClientListResponse;
import vn.harry.callrecorder.response.ClientList.ResponseObjectItem;
import vn.harry.callrecorder.ui.all.AllCallFragment;
import vn.harry.callrecorder.util.RecordingUtils;

/**
 * Created by Harry_Hai on 2/13/2018.
 */

public class ClientsFragment extends AllCallFragment implements OnServiceCallResponse {
    //protected List<Recording> listInComing = new ArrayList<>();
    protected List<ResponseObjectItem> listInComing = new ArrayList<>();
    private ClientsAdapter clientsAdapter;

    @SuppressLint("SetTextI18n")
    @Override
    public void onUpdateView(List<Recording> allItems) {
        listInComing.clear();
        new ServiceCallUtils(getContext(), "Kyc/KycBySubBrocker", new HashMap<>(), ClientListResponse.class, ServiceCallUtils.POST_WITH_HEADER, ClientsFragment.this);
    }

    @Override
    public void onHandleSearch(MessageEvent event) {
        if (event.getCurrentItem() == INCOMING) {
            filter(event.getMessage());
        }
    }

    @Override
    public void onResponseSuccess(Object response) {
        ClientListResponse clientListResponse = (ClientListResponse) response;
        if (clientListResponse.isResponseStatus()) {
            if (clientListResponse.getResponseObject() != null) {
                if (clientListResponse.getResponseObject().size() > 0) {
                    mData.addAll(clientListResponse.getResponseObject());
                    mRecyclerView.getRecycledViewPool().clear();
                    clientsAdapter = new ClientsAdapter(getContext(), clientListResponse.getResponseObject());
                    mRecyclerView.setAdapter(clientsAdapter);
                    clientsAdapter.notifyDataSetChanged();
                    RecordingUtils.addAllClinetList(getContext(), clientListResponse.getResponseObject());
                } else {
                    Toast.makeText(getContext(), "No Clients Available", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(getContext(), "No Clients Available", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onResponseFail(String strErrorMessage) {
        Toast.makeText(getContext(), strErrorMessage, Toast.LENGTH_SHORT).show();
    }
}