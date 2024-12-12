package test;

public interface MemberDB {
	public void conn();
	public void insert(String mem);
	public void select(String mem);
	public void update(String mem);
	public void delete(String mem);
	public void disconn();

}
