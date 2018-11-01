package test;

import java.util.ArrayList;
import java.util.List;

import model.ComBo;

public class SqlDemo {
	private List<ComBo> comli;
	public static void main(String[] args) {
		List<String> li = new ArrayList<String>();
		li.add("历史"); 
		li.add("名著");
		li.add("玄幻");
		li.add("科幻");
		li.add("言情");
		System.out.println(li);
		List<ComBo> comli = new ArrayList<ComBo>();
		for (int i = 0; i < li.size(); i++) {
			ComBo com = new ComBo();
			com.setId(li.get(i));
			com.setText(li.get(i));
			comli.add(com);
		}
//		List<Integer> subList = li.subList(0, 10);
		System.out.println(comli);
//		System.out.println(Integer.parseInt("10.00"));
	}
}
