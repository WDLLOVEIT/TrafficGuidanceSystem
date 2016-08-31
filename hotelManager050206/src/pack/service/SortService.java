package pack.service;

import pack.beans.*;

import java.util.*;

public interface SortService {
	List<Room> bookSort(String s,String l);
	List<Room> checkInSort(String s,int last);
}

