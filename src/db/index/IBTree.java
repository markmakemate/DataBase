package db.index;

import java.nio.ByteBuffer;
import java.util.List;

import db.bstar.BTreeNode;
import db.bstar.IdxBlock;
import db.log.CellLogMgr;
import db.tx.AbortTransException;
import db.tx.Trans;


public interface IBTree {

	public BTreeNode getRoot();
	
    public void print(List<String> strList);
    
    public String toString();
    
	public void printNext();
	
	public void printTreePrior();
	
	public IdxBlock insert(int key, IdxBlock var, Trans tid, CellLogMgr logMgr) throws AbortTransException ;
	
	public IdxBlock update(int key, IdxBlock var, Trans tid, CellLogMgr logMgr) throws AbortTransException ;
	
	public IdxBlock delete(int key, Trans tid, CellLogMgr logMgr) throws AbortTransException ;
	
	public IdxBlock search(int key, Trans tid);
	
	public boolean rollback(int key, Trans tid, CellLogMgr logMgr);
	
	public boolean commit(int key, Trans tid, CellLogMgr logMgr);
	
	public BTreeNode seekNode(int key);
	
	public int count(int fromKey, int toKey);
	
	public List<IdxBlock> range(int fromKey, int toKey, boolean isInc);
	
	public void toByteBuffer(List<ByteBuffer> list);
	
}