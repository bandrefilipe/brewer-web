package bandrefilipe.brewer.web.repository;

import bandrefilipe.brewer.web.integration.request.BeverageRegistrationRequest;
import bandrefilipe.brewer.web.integration.response.BeverageRegistrationResponse;

public interface BeverageRepository {

    BeverageRegistrationResponse persist(BeverageRegistrationRequest beveragePayload);
}
