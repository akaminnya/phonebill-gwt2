package edu.pdx.cs410J.whitlock.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import edu.pdx.cs410J.AbstractPhoneBill;
import edu.pdx.cs410J.whitlock.client.PhoneBill;
import edu.pdx.cs410J.whitlock.client.PhoneBillService;
import edu.pdx.cs410J.whitlock.client.PhoneCall;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The server-side implementation of the Phone Bill service
 */
public class PhoneBillServiceImpl extends RemoteServiceServlet implements PhoneBillService {

    private final Map<String, PhoneBill> data = new HashMap<String, PhoneBill>();

    @Override
    public AbstractPhoneBill addCall(String customerName, PhoneCall aCall) {

        PhoneBill aBill = data.get(customerName);

        if (aBill == null) {
            aBill = new PhoneBill(customerName);
        }
        aBill.addPhoneCall(aCall);

        data.put(customerName, aBill);

        return aBill;
    }

    @Override
    public AbstractPhoneBill searchCalls(String customerName) {
        PhoneBill aBill = data.get(customerName);
        if (aBill == null)
            return null;
        else
            return aBill;

    }


    /**
     * Log unhandled exceptions to standard error
     *
     * @param unhandled The exception that wasn't handled
     */
    @Override
    protected void doUnexpectedFailure(Throwable unhandled) {
        unhandled.printStackTrace(System.err);
        super.doUnexpectedFailure(unhandled);
    }
}
