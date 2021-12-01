package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Graphic;
import java.net.URL;
import java.util.ResourceBundle;


public class MainController implements Initializable {

	public final  int INF = 9999;
	
	private Graphic graphic;

	private double xOffset = 0;
	private double yOffset = 0;
	
		
	@FXML
	private ChoiceBox<String> cbDestino;

	@FXML
	private ChoiceBox<String> cbOrigen;

	@FXML
	private TextArea taRoute;



	public MainController() {
		graphic = new Graphic();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ObservableList<String> locations = FXCollections.observableArrayList("Domino's Pizza",
				"Patios de la Flora",
				"PriceSmart",
				"Centro Empresa",
				"Colsubsidio",
				"Olivenza",
				"Santa Mar�a de los Vientos",
				"Balc�n de las Flores",
				"Cheers",
				"Conjunto Arag�n",
				"Harold Montes",
				"Parque de las Flores",
				"Santinis",
				"Torremolinos",
				"BBVA",
				"C&M Consultants");
		cbDestino.setItems(locations);
		cbOrigen.setItems(locations);

	}

	@FXML
	void windowDragged(MouseEvent event) {
		Stage stage = (Stage) cbDestino.getScene().getWindow();
		stage.setX(event.getScreenX() + xOffset);
		stage.setY(event.getScreenY() + yOffset);
	}

	@FXML
	void windowPressed(MouseEvent event) {
		Stage stage = (Stage) cbDestino.getScene().getWindow();
		xOffset = stage.getX() - event.getScreenX();
		yOffset = stage.getY() - event.getScreenY();
	}

	private boolean checkFields() {
		if (cbDestino.getSelectionModel().isEmpty()==false && cbOrigen.getSelectionModel().isEmpty()==false) {
			return true;
		}else {
			return false;
		}

	}

	@FXML
	public void fastRoute(ActionEvent event) {
		String [] route = null;
		String finalRoute = "Ruta:"+"\nOrigen: "+cbOrigen.getSelectionModel().getSelectedItem()+"     "
							+ "Destino: "+cbDestino.getSelectionModel().getSelectedItem()+"\n";

		if(checkFields()) {			
			graphic.bestFasterWay(cbOrigen.getSelectionModel().getSelectedIndex());			
			
			if (cbDestino.getSelectionModel().getSelectedIndex()>cbOrigen.getSelectionModel().getSelectedIndex()) {
				route = graphic.getMessageList().get(cbDestino.getSelectionModel().getSelectedIndex()-1).split(" ");
				
			}else if (cbDestino.getSelectionModel().getSelectedIndex()<cbOrigen.getSelectionModel().getSelectedIndex()) {
				route = graphic.getMessageList().get(cbDestino.getSelectionModel().getSelectedIndex()).split(" ");				
			}else {
				taRoute.setText("Ya te encuentras en el lugar a donde deseas ir");
				
			}
			/*		
			for (int h =0;h<route.length;h++) {
				System.out.println("ROUTE: "+route[h]);
			}
			*/
			boolean stop = false;
			if (route!=null) {
				for (int i=0;i<route.length;i++) {
					for (int j=0;j<=cbOrigen.getItems().size() && !stop;j++) {
						
						if (Integer.parseInt(route[i])==j) {
							cbOrigen.getSelectionModel().select(j);
							if (i==route.length-1) {
								finalRoute += cbOrigen.getSelectionModel().getSelectedItem();
							}else {
								finalRoute += cbOrigen.getSelectionModel().getSelectedItem() + " -> " ;
							}	
							
							stop = true;
						}
					}
					
					stop = false;
				}
			
				taRoute.setText(finalRoute);		
			}
			
		}
		cbOrigen.getSelectionModel().clearSelection();
		cbDestino.getSelectionModel().clearSelection();
	}

	@FXML
	public void secureRoute(ActionEvent event) {
		String [] route = null;
		String finalRoute = "Ruta:"+"\nOrigen: "+cbOrigen.getSelectionModel().getSelectedItem()+"     "
							+ "Destino: "+cbDestino.getSelectionModel().getSelectedItem()+"\n";

		if(checkFields()) {			
			graphic.bestSecureWay(cbOrigen.getSelectionModel().getSelectedIndex());
			
			
			if (cbDestino.getSelectionModel().getSelectedIndex()>cbOrigen.getSelectionModel().getSelectedIndex()) {
				route = graphic.getMessageList().get(cbDestino.getSelectionModel().getSelectedIndex()-1).split(" ");
				
			}else if (cbDestino.getSelectionModel().getSelectedIndex()<cbOrigen.getSelectionModel().getSelectedIndex()) {
				route = graphic.getMessageList().get(cbDestino.getSelectionModel().getSelectedIndex()).split(" ");				
			}else {
				taRoute.setText("Ya te encuentras en el lugar a donde deseas ir");
			}
			
		
			boolean stop = false;
			
			if (route!=null) {
				for (int i=0;i<route.length;i++) {
					for (int j=0;j<=cbOrigen.getItems().size() && !stop;j++) {
						
						if (Integer.parseInt(route[i])==j) {
							cbOrigen.getSelectionModel().select(j);
							if (i==route.length-1) {
								finalRoute += cbOrigen.getSelectionModel().getSelectedItem();
							}else {
								finalRoute += cbOrigen.getSelectionModel().getSelectedItem() + " -> " ;
							}	
							
							stop = true;
						}
					}
					
					stop = false;
				}
				
				taRoute.setText(finalRoute);
			}		
		}
		cbOrigen.getSelectionModel().clearSelection();
		cbDestino.getSelectionModel().clearSelection();
	}

	
}