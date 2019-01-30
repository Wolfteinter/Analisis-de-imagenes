/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muestreo;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author Roberto Cruz Leija
 */
public class Grafica {
    
    private JFreeChart grafica;
    private XYSeriesCollection series;
    private String titulo;
    private String tituloEjeX;
    private String tituloEjeY;

    public Grafica(String titulo,
                   String tituloEjeX,
                   String tituloEjeY) {
        this.titulo = titulo;
        this.tituloEjeX = tituloEjeX;
        this.tituloEjeY = tituloEjeY;
        this.grafica = null;
        this.series = new XYSeriesCollection();
     }
    
    public void agregarSerie(String id,int [] frecuencias){
        XYSeries serie = new XYSeries(id);
        for (int x=0; x<frecuencias.length;x++){
             serie.add(x,frecuencias[x]);
        }
       
        this.series.addSeries(serie);
    }
    
     
    public void crearGrafica(){
    this.grafica = ChartFactory.createXYLineChart(
             titulo,tituloEjeX, tituloEjeY, series);
        ChartFrame panel = new ChartFrame("Tiempos",grafica);
        panel.setVisible(true);
    }
    public void crearGraficaPuntos(){
    this.grafica = ChartFactory.createScatterPlot(titulo, titulo, titulo, series);
            
        ChartFrame panel = new ChartFrame("Tiempos",grafica);
        panel.setVisible(true);
    }
    
    
}
