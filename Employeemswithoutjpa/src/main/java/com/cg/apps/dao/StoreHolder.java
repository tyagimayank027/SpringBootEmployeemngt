package com.cg.apps.dao;

import java.util.*;

import org.springframework.stereotype.Component;
import com.cg.apps.entities.*;
import com.cg.apps.entities.*;
@Component
public class StoreHolder {
	
	public StoreHolder() {
		
	}
		
	private Map<Integer, Employee>store = new HashMap<>();
	
	public Map<Integer, Employee> getStore() {
        return store;
    }
	
	
}
