package com.nt.dao;

public interface OneToManyDAO {
	public  void saveData();
	public  void loadDataUsingParent();
	public void  loadDataUsingParentByUserId(int userId);
	public void  deleteDataUsingParentByUserId(int userId);
	public  void deleleAllChildsOfAParentByUserId(int userId);
	public void  deleteOneChildfromCollectionOfChildsBelogingToAParentByUserId(int userId);

}
