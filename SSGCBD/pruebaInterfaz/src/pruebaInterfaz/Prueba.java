package pruebaInterfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;





import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class Prueba extends JFrame {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static JTextArea jtexArea[];
	public static ArrayList<JPanel> jpanels;
	public static String tablas [];
	
	
	static int nTablas;
	
	static int xs[] = {1,-1, 0, 0};
	static int ys[] = {0,0, 1, -1};
	
	public static String ruta;
	
	public static void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, IOException {
		// TODO Auto-generated method stub
	
		String a = "C4:D7";
		String b = "F4:G7";
		
		tablas = new String[2];
		tablas[0]=a;
		tablas[1]=b;
		
		MarcarTablas(tablas);
		nTablas = 2;
		
		
		jpanels = new ArrayList<JPanel>();
		InputStream is = new FileInputStream("C:/Users/admin/Desktop/Prueba.xlsx");
        Workbook libro = WorkbookFactory.create(is);
        
        is = new FileInputStream("C:/Users/admin/Desktop/VisitadosLibro1.xlsx");
        Workbook visit = WorkbookFactory.create(is);        
        recorrerHoja(libro, visit);
      
		Prueba p = new Prueba();
		p.setVisible(true);
		System.out.println("Fin");
	}
	
	public Prueba(){
		setTitle("Agregar");
		this.setSize(1100, 600);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		
		inicializarComponentes();
	}
	
	
	public void inicializarComponentes(){
		
		for(int i=0;i<tablas.length;i++){
			JPanel jpanel = new JPanel();
			jpanel.setBorder(BorderFactory.createTitledBorder("Container"+i));
			String inicio = tablas[i].split(":")[0];
			String fin = tablas[i].split(":")[1];
			Nodo coordinates=getCoordinates(inicio);
			Nodo size = getSizes(inicio, fin);
			jpanel.setBounds(coordinates.x,coordinates.y, size.x + 40, size.y + 40);
			jpanel.setLayout(null);
			Object[][] data = {{"asd", "sad"}, 
							   {"sad", "sasad"},
							   {"sad", "sad"},
							   {"sad", "sad"},
							   {"sad", "sad"},
							   {"sad", "sad"},
							   {"sad", "sad"}};
			String[] columnNames={"nombre","apellido"};
			
			JTable table = new JTable(data, columnNames);
			table.setBounds( 20, 20, size.x, size.y);
			jpanel.add(table);
			jpanels.add(jpanel);
		}
		
		for(int i=0;i<jpanels.size();i++){
			getContentPane().add(jpanels.get(i));
		}
	}	
	
	
	public static Nodo getCoordinates2(String inicio){
		Nodo res;
		String ws = inicio.split("-")[1];
		String hs = inicio.split("-")[0];
		int w = Integer.parseInt(ws) *120;
		int h = Integer.parseInt(hs) *25;
		res = new Nodo(w, h);
		return res;
	}
	
	public static Nodo getCoordinates(String inicio){
		Nodo res;
		int w = (inicio.charAt(0)-65) *120;
		int h = ( Integer.parseInt(capturarNumeros(inicio))-1)*25;
		res = new Nodo(w, h);
		return res;
	}
	
	public static String capturarNumeros(String s){
		String r="";
		for(int i=1;i<s.length();i++){
			r+=s.charAt(i);
		}
		return r;
	}
	
	public static Nodo getSizes(String inicio,String fin){
		Nodo res;
		int w = ( (fin.charAt(0) - 65)  -  (inicio.charAt(0) - 65) + 1 )*120;
		int h = ( Integer.parseInt(capturarNumeros(fin)) - Integer.parseInt(capturarNumeros(inicio)) + 1)*25 ;  
		res = new Nodo(w, h);
		return res;
	}
	
	public static Nodo getSizes2(String inicio,String fin){
		Nodo res;
		
		String ws1 = inicio.split("-")[1];
		String hs1 = inicio.split("-")[0];
		
		String ws2 = fin.split("-")[1];
		String hs2 = fin.split("-")[0];
		
		int w = ( (Integer.parseInt(ws2))  -  (Integer.parseInt(ws1)) + 1 )*120;
		int h = ( Integer.parseInt(capturarNumeros(hs2)) - Integer.parseInt(capturarNumeros(hs1)) + 1)*25 ;  
		res = new Nodo(w, h);
		return res;
	}
	
	public static  void MarcarTablas(String [] sizes) throws IOException, EncryptedDocumentException, InvalidFormatException{
        Workbook visit = new XSSFWorkbook();
        Sheet sheetV =  visit.createSheet();
        for(int i=0;i<sizes.length;i++){
        	String inicio = sizes[i].split(":")[0], fin =  sizes[i].split(":")[1];
        	for(int  j = Integer.parseInt(capturarNumeros(inicio))-1 ; j <Integer.parseInt(capturarNumeros(fin)) ;j++){
        		Row r= sheetV.getRow(j);
        		if(r==null)
        			r= sheetV.createRow(j);
        		for(int k =  (inicio.charAt(0)-65); k <=(fin.charAt(0) - 65);k++ ){
        			Cell c = r.createCell(k);
        			c.setCellValue(1);
        		}
        	}
        }
        FileOutputStream fos = new FileOutputStream("C:/Users/admin/Desktop/VisitadosLibro1.xlsx");
	    visit.write(fos);
	    visit.close();
	    fos.close();
	}
	
	public static boolean isValid(int i, int j) {
		if(i >= 0 && i < 10  && j >= 0 && j < 10)
			return true;
		return false;
	}
	
	public static ArrayList<Nodo> bfs(int i, int j,Sheet sheetL,Sheet sheetV) {	
		
		Row r = sheetL.getRow(i);
		Cell c = r.getCell(j);
		
		ArrayList<Nodo> res = new ArrayList<Nodo>();
		res.add(new Nodo(i, j));
		
 		Row rv = sheetV.getRow(i);
		Cell cv = r.createCell(j);
		cv.setCellValue(1);
		
		Queue<Cell> q =   new LinkedList<Cell>();
		q.add(c);
		
		while (!q.isEmpty()) {
			
			Cell u = q.peek();
			q.poll();
			for(int k = 0; k < 4; k++) {
				int vx = u.getRowIndex()    + xs[k];
				int vy = u.getColumnIndex() + ys[k];
				
				if(isValid(vy, vy)){
					r = sheetL.getRow(vx);
					if(r==null) continue;
					
					c = r.getCell(vy);
					if (c !=null  ) {
						rv = sheetV.getRow(vx);
						if(rv==null){
							rv=sheetV.createRow(vx);
							cv=rv.createCell(vy);
							cv.setCellValue(1);
							res.add(new Nodo(vx, vy));
							q.add(c);
						}else{
							cv = rv.getCell(vy);
							if(cv == null) {
								cv = rv.createCell(vy);
								cv.setCellValue(1);
								res.add(new Nodo(vx, vy));
								q.add(c);
							}
						}
					}						
				}
			}
		}
		return res;
	}
	
	public static void recorrerHoja(Workbook libro, Workbook visit) throws IOException {
		Sheet sheetL =  libro.getSheetAt(0);
		Sheet sheetV =  visit.getSheetAt(0);
		int nmax = sheetL.getLastRowNum()+1;
		
		for (int i = 0; i <nmax; i++) {
        	Row r =  sheetL.getRow(i);
        	if(r==null) continue;
        	
        	Row rv = sheetV.getRow(i);
        	if(rv ==null)
        		rv = sheetV.createRow(i);
        	
        	for (int j = 0; j <r.getLastCellNum(); j++) {
	    		Cell c = r.getCell(j);
	    		Cell cv = rv.getCell(j);
	    	
	            if(c != null && cv==null ) { 
	            	if(c.getCellType()==Cell.CELL_TYPE_BLANK)
	            		continue;
	            	ArrayList<Nodo> res = bfs( i, j,sheetL,sheetV);
	            	Collections.sort(res);
	            	int m = res.size();
	            	if(m>1){
	            		String key =res.get(0).x +"-"+ res.get(0).y+":" + res.get(m-1).x +"-" + res.get(m-1).y ;
	            		
	            	
	            		String inicio = key.split(":")[0];
	                    String fin  = key.split(":")[1];
	                    JPanel jpanel = new JPanel();
	         			jpanel.setBorder(BorderFactory.createTitledBorder("Container"+ (nTablas++)));
	         		
	         			Nodo coordinates=getCoordinates2(inicio);
	         			Nodo size = getSizes2(inicio, fin);
	         			jpanel.setBounds(coordinates.x,coordinates.y, size.x + 40, size.y+ 40);
	         			jpanel.setLayout(null);
	         			
	         			Nodo relativo = getCoordinates2(res.get(0).x +"-" +res.get(0).y);
	         			int relativex = relativo.x ;
	         			int relativey = relativo.y ;
	         			
	         			for(int k=0;k<res.size();k++){
	         				int x = res.get(k).x;
	         				int y = res.get(k).y;
	         				Row rr = sheetL.getRow(x);
	         				Cell  cc = rr.getCell(y);
	         				Nodo cor = getCoordinates2(x+"-"+y);
	         				JLabel label = new JLabel("hola");
	         				label.setBorder(BorderFactory.createLineBorder(Color.black));
	         				label.setBounds( cor.x - relativex + 40 , cor.y - relativey + 25, 80, 15);
	         				jpanel.add(label);
	         			}
	         			jpanels.add(jpanel);
	            		System.out.println(key + " " + "Container"+(nTablas));
	            	}
	            }
	        }
	    }
		FileOutputStream fos = new FileOutputStream("C:/Users/admin/Desktop/VisitadosLibro1.xlsx");
	    visit.write(fos);
	    visit.close();
	    fos.close();
	}

}

class Nodo implements Comparable<Nodo> {

	int x,y;
	public Nodo(int x,int y){
		this.x = x;
		this.y = y;
	}
	public int compareTo(Nodo n) {
		if(x>n.x){
			return 1;
		}
		else if (x==n.x){
			if(y>n.y)
				return 1;
			else if(y==n.y)
				return 0;
		}
		return -1;
	}
}