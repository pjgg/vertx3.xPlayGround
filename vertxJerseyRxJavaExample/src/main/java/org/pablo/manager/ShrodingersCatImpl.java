package org.pablo.manager;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import rx.Observable;

public class ShrodingersCatImpl implements ShrodingersCat {
	
	private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	private Boolean status = Boolean.FALSE;
	
//	private Action1<Boolean> onNext = statusEvent -> {LOG.info("nextEvent has come" + statusEvent.booleanValue());};
//	private Action1<Throwable> onError = statusEvent -> {LOG.info("errorEvent has come" + statusEvent.getMessage());};
//	private Action0 onComplete = () -> {LOG.info("end!");};
		
	@Override
	public Observable<Boolean> isAlivePush() {

//		return Observable.create(subscriber -> {
//			subscriber.onNext(status);
//			//subscriber.onCompleted();
//		});
		
	return Observable.just(status);
	}

	@Override
	public void setCatSatus(Boolean status) {
		setStatus(status);
	}
	
	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	@Override
	public CompletableFuture<Boolean> isAlivePull() {
		return CompletableFuture.completedFuture(status);		
	}

}
