package swing_examples2;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class TestCombo {
	
	public void fillCB(){
//	    try{
//	    	List<Perfil> lista = new ArrayList<>();
//	    	
//	        ResultSet rs;
//	        perfil.select();//esse método busca no BD os perfis existentes
//	        rs=perfil.getRs();//aqui eu pego o ResultSet existente na minha classe perfil
//	        while(rs.next()){
//	        	Perfil p  = new Perfil();
//	        	p.setId(rs.getInt("id"));
//	        	p.setNome(rs.getString("nome"));
//	        	lista.add(p);
//	        }
//	        
//	        JComboBox cbPerfil = new JComboBox<>();
//	        cbPerfil.setModel(new GenericComboModel<Perfil>(lista));
//	        
//	    }
//	    catch(SQLException erro){
//	        JOptionPane.showMessageDialog(null, "Erro!\n"+erro);
//	    }
	}

	class Perfil {

		private int id;
		private String nome;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}
		
		@Override
		public String toString() {
			return this.nome;
		}
	}
	
	class GenericComboModel<E> extends AbstractListModel<E> implements ComboBoxModel<E>{
		
		private List<E> itemList;
		private E selection;
		
		public GenericComboModel(List<E> list) {
			this.itemList = list;
		}

		@Override
		public int getSize() {
			return this.itemList.size();
		}

		@Override
		public E getElementAt(int index) {
			return this.itemList.get(index);
		}

		@Override
		public Object getSelectedItem() {
			return this.selection;
		}

		@Override
		public void setSelectedItem(Object anItem) {
			this.selection = (E) anItem;
		}

	}

}
