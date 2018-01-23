package edu.fdu.se.astdiff.generatingactions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.jgrapht.DirectedGraph;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;

import com.github.gumtreediff.actions.model.Action;
import com.github.gumtreediff.actions.model.Delete;
import com.github.gumtreediff.actions.model.Insert;
import com.github.gumtreediff.actions.model.Move;
import com.github.gumtreediff.actions.model.Update;

public class GeneratingActionsData {

	private List<Integer> dstLayerLastNodeIndex;

	private List<Action> insertActions;
	private List<Action> updateActions;
	private List<Action> moveActions;
	private List<Action> deleteActions;
	private List<Action> allActions;

	private Map<Action, Integer> allActionMap;

	public GeneratingActionsData() {
		super();
		this.dstLayerLastNodeIndex = new ArrayList<Integer>();
		this.insertActions = new ArrayList<Action>();
		this.moveActions = new ArrayList<Action>();
		this.updateActions = new ArrayList<Action>();
		this.deleteActions = new ArrayList<Action>(); 
		this.allActions = new ArrayList<Action>();
		this.startNodes = new ArrayList<>();
		this.allActionMap = new HashMap<Action,Integer>();
	}

	public void addAction(Action action, int actionIndex) {
		if (action instanceof Insert) {
			this.insertActions.add(action);
		} else if (action instanceof Update) {
			this.updateActions.add(action);
		} else if (action instanceof Move) {
			this.moveActions.add(action);
		} else if (action instanceof Delete) {
				this.deleteActions.add(action);
		}
		this.allActions.add(action);
	}


	public List<Integer> getDstLayerLastNodeIndex() {
		return dstLayerLastNodeIndex;
	}


	public List<Action> startNodes;



	public List<Action> getInsertActions() {
		return insertActions;
	}

	public void setInsertActions(List<Action> insertActions) {
		this.insertActions = insertActions;
	}

	public List<Action> getUpdateActions() {
		return updateActions;
	}

	public void setUpdateActions(List<Action> updateActions) {
		this.updateActions = updateActions;
	}

	public List<Action> getMoveActions() {
		return moveActions;
	}

	public void setMoveActions(List<Action> moveActions) {
		this.moveActions = moveActions;
	}

	public List<Action> getDeleteActions() {
		return deleteActions;
	}

	public void setDeleteActions(List<Action> deleteActions) {
		this.deleteActions = deleteActions;
	}
	

	

	public List<Action> getAllActions() {
		return allActions;
	}

	public void setAllActions(List<Action> allActions) {
		this.allActions = allActions;
	}

	public void generateActionMap() {
		for (Action tmp : this.insertActions) {
			this.allActionMap.put(tmp, 0);
		}
		for (Action tmp : this.moveActions) {
			this.allActionMap.put(tmp, 0);
		}
		for (Action tmp : this.updateActions) {
			this.allActionMap.put(tmp, 0);
		}
		for (Action tmp : this.deleteActions) {
			this.allActionMap.put(tmp, 0);
		}
	}

	public Map<Action, Integer> getAllActionMap() {
		return allActionMap;
	}

}