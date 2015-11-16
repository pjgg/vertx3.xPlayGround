package org.pablo.utils;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface SuperPabloConverter <A, B>{
	
    default Collection<B> convertToList(final Collection<A> input) {
        return input.stream().map(this::apply).collect(Collectors.toList());
    }
    
    default Collection<A> convertReverseTypeToList(final Collection<B> input) {
        return input.stream().map(this::applyReverseType).collect(Collectors.toList());
    }
    
    default Stream<B> convertToStream(final Stream<A> input) {
        return input.map(element -> this.apply(element));
    }
   
    B apply(A t);
    
    A applyReverseType(B t);
}

