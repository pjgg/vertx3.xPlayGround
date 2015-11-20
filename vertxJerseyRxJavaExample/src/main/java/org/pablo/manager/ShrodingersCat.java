package org.pablo.manager;

import java.util.concurrent.CompletableFuture;

import rx.Observable;


public interface ShrodingersCat {
	
	Observable<Boolean> isAlivePush();
	
	CompletableFuture<Boolean> isAlivePull();
	
	void setCatSatus(Boolean status);
}
