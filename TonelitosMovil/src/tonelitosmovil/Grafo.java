/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tonelitosmovil;

/**
 *
 * @author rick
 */
public class Grafo {

    private List nodos;

    public Grafo(List nodos) {
        this.nodos = nodos;
    }

    public Grafo() {
        nodos = new List();
    }

    public List getNodos() {
        return nodos;
    }

    public void setNodos(List nodos) {
        this.nodos = nodos;
    }

    public Node First(Node vertex) {
        int nodeIndex = -1;

        for (int i = 0; i < nodos.size(); i++) {
            if (vertex.getID() == nodos.elementAt(i).getID()) {
                nodeIndex = ((Arista) nodos.elementAt(i).getAristas().elementAt(0).getValue()).getNodoFinal().getID();
                break;
            }
        }
        if (nodeIndex == -1) {
            System.err.println("Index out of bounds");
            return null;
        }
        // el -1 se aplica si se empieza con ID 1 y no con ID 0
        return nodos.elementAt(nodeIndex - 1);
    }

    public Node getVertex(Node vertex, int posicion) {
        int nodeIndex = -1;

        for (int i = 0; i < nodos.size(); i++) {
            if (vertex.getID() == nodos.elementAt(i).getID()) {
                nodeIndex = ((Arista) nodos.elementAt(i).getAristas().elementAt(posicion).getValue()).getNodoFinal().getID();
                break;
            }
        }
        if (nodeIndex == -1) {
            System.err.println("Index out of bounds");
            return null;
        }
        // el -1 se aplica si se empieza con ID 1 y no con ID 0
        return nodos.elementAt(nodeIndex - 1);
    }

    public void addVertex(Node vertex) {
        nodos.elementAt(nodos.size() - 1).setNext(vertex);
    }

    public void addEdge(Node vertex, Arista edge) {

        for (int i = 0; i < nodos.size(); i++) {
            if (vertex.getID() == nodos.elementAt(i).getID()) {
                nodos.elementAt(i).getAristas().push_back(edge);
                break;
            }
        }
    }

    public void removeVertex(int posicion) {
        int nodeIndex = -1;

        for (int i = 0; i < nodos.size(); i++) {
            if (nodos.elementAt(posicion).getID() == nodos.elementAt(i).getID()) {
                nodeIndex = i;
                break;
            }
        }

        if (nodeIndex != -1) {
            for (int i = 0; i < nodos.size(); i++) {
                for (int j = 0; j < nodos.elementAt(i).getAristas().size(); j++) {
                    if (((Arista) nodos.elementAt(i).getAristas().elementAt(j).getValue()).getNodoFinal().getID()
                            == nodos.elementAt(nodeIndex).getID()
                            || ((Arista) nodos.elementAt(i).getAristas().elementAt(j).getValue()).getNodoInicial().getID()
                            == nodos.elementAt(nodeIndex).getID()) {
                        removeEdge(nodos.elementAt(nodeIndex), ((Arista) nodos.elementAt(i).getAristas().elementAt(j).getValue()));
                    }
                }
            }

            nodos.remove(nodeIndex);
        } else {
            System.err.println("Index out of bounds");
        }
    }

    public void removeEdge(Node vertex, Arista edge) {

        for (int i = 0; i < nodos.size(); i++) {
            if (vertex.getID() == nodos.elementAt(i).getID()) {
                for (int j = 0; j < nodos.elementAt(i).getAristas().size(); j++) {
                    if (((Arista) nodos.elementAt(i).getAristas().elementAt(j).getValue()).getNodoInicial().getID()
                            == edge.getNodoInicial().getID()
                            && ((Arista) nodos.elementAt(i).getAristas().elementAt(j).getValue()).getNodoFinal().getID()
                            == edge.getNodoFinal().getID()) {

                        nodos.elementAt(i).getAristas().remove(j);
                        break;

                    }
                }

            }
        }

    }

    public List Dijkstra(Node origin, Node destiny/*, List nodes*/) {
        List permanentes = new List();
        List notPermanents = new List();
        origin.setDijkstraNum(0);
        permanentes.push_back(origin);

        for (int i = 0; i < nodos.size(); i++) {
            nodos.elementAt(i).setDijkstraNum(Integer.MAX_VALUE);
            nodos.elementAt(i).setDijkstraPath(new List());
            if (nodos.elementAt(i) != origin) {
                notPermanents.push_back(nodos.elementAt(i));
            }
        }
        while (nodos.size() == permanentes.size()) {
            Node temp = permanentes.last();
            for (int i = 0; i < temp.getAristas().size(); i++) {
                for (int j = 0; j < permanentes.size(); j++) {
                    if (((Arista) temp.getAristas().elementAt(i).getValue()).getNodoFinal() != permanentes.elementAt(j)) {
                        if (((Arista) temp.getAristas().elementAt(i).getValue()).getDistancia() + temp.getDijkstraNum() < ((Arista) temp.getAristas().elementAt(i).getValue()).getNodoFinal().getDijkstraNum()) {
                            ((Arista) temp.getAristas().elementAt(i).getValue()).getNodoFinal().setDijkstraNum(((Arista) temp.getAristas().elementAt(i).getValue()).getDistancia() + temp.getDijkstraNum());
                            ((Arista) temp.getAristas().elementAt(i).getValue()).getNodoFinal().setDijkstraPath(temp.getDijkstraPath());
                            ((Arista) temp.getAristas().elementAt(i).getValue()).getNodoFinal().addToPath(((Arista) temp.getAristas().elementAt(i).getValue()));
                        }
                    }
                }
            }
            long min = Integer.MAX_VALUE;
            for (int i = 0; i < notPermanents.size(); i++) {
                if (notPermanents.elementAt(i).getDijkstraNum() < min) {
                    min = notPermanents.elementAt(i).getDijkstraNum();
                    temp = notPermanents.elementAt(i);
                }
            }
            int delete = notPermanents.find(temp);
            notPermanents.remove(delete);
            permanentes.push_back(temp);
        }

        return origin.getDijkstraPath();
    }

    public List FLoyd() {
        List optimos = new List();
        List lista;
        List ponderaciones = new List();
        List rows = new List();
        Node temp = new Node();
        for (int i = 0; i < this.nodos.size(); i++) {
            rows.insert(i, temp);
        }
        for (int i = 0; i < this.nodos.size(); i++) {
            ponderaciones.insert(i, rows);
        }
        //con lo superior creo la matriz
        List caminos = ponderaciones;

        for (int i = 0; i < caminos.size(); i++) {
            for (int j = 0; j < caminos.size(); j++) {
                ((List) caminos.elementAt(i).getValue()).elementAt(j).setValue(nodos.elementAt(j).getID());
                // ((List) caminos.elementAt(i).getValue()).elementAt(i).setValue(0);
            }
        }

        lista = Camino(caminos, ponderaciones);
        ponderaciones = llenar(ponderaciones);

        //lleno caminos
        //lleno 
        return optimos;

    }

    private List Camino(List caminos, List ponderaciones) {
        List lista = new List();
        for (int i = 0; i < caminos.size(); i++) {
            for (int j = 0; j < caminos.size(); j++) {
                for (int k = 0; k < caminos.size(); k++) {
                    if (((int) ((List) ponderaciones.elementAt(i).getValue()).elementAt(k).getValue())
                            + ((int) ((List) ponderaciones.elementAt(k).getValue()).elementAt(j).getValue())
                            < ((int) ((List) ponderaciones.elementAt(i).getValue()).elementAt(j).getValue())) {
                        ((List) ponderaciones.elementAt(i).getValue()).elementAt(j).setValue(
                                ((int) ((List) ponderaciones.elementAt(i).getValue()).elementAt(k).getValue())
                                + ((int) ((List) ponderaciones.elementAt(k).getValue()).elementAt(j).getValue()));
                        ((List) caminos.elementAt(i).getValue()).elementAt(j).setValue(k);
                    }
                }
            }
        }
        lista.push_back(caminos);
        lista.push_back(ponderaciones);
        return lista;

    }

    private List llenar(List ponderaciones) {
        /*for (int i = 0; i < ponderaciones.size(); i++) {
            for (int j = 0; j < ponderaciones.size(); j++) {
                ((List) ponderaciones.elementAt(i).getValue()).elementAt(i).setValue(0);
                for (int k = 0; k < ponderaciones.size(); k++) {
                    if ((int) ((List) ponderaciones.elementAt(i).getValue()).elementAt(j).getValue() != 0
                            && ((Arista) nodos.elementAt(j).getAristas().elementAt(k).getValue()).getNodoFinal().getID() == j) {
                        ((List) ponderaciones.elementAt(i).getValue()).elementAt(i).setValue(((Arista) nodos.elementAt(j).getAristas().elementAt(k).getValue()).getDistancia());
                    } else {
                        ((List) ponderaciones.elementAt(i).getValue()).elementAt(i).setValue(Integer.MAX_VALUE);
                    }
                }

            }
        }
*/
       // List row = new List();
        for (int i = 0; i < ponderaciones.size(); i++) {
            for (int m = 0; m < 10; m++) {
                for (int j = 0; j < nodos.size(); j++) {
                    for (int k = 0; k < nodos.elementAt(j).getAristas().size(); k++) {
                        ((List) ponderaciones.elementAt(i).getValue()).elementAt(i).setValue(0);
                        if (((Arista) nodos.elementAt(j).getAristas().elementAt(k).getValue()).getNodoFinal().getID() == m) {
                           ((List) ponderaciones.elementAt(i).getValue()).elementAt(m).setValue(
                           ((Arista) nodos.elementAt(j).getAristas().elementAt(k).getValue()).getDistancia());
                        } else {
                            ((List) ponderaciones.elementAt(i).getValue()).elementAt(m).setValue(Integer.MAX_VALUE);
                        }

                    }
                }
            }

        }
        return ponderaciones;

    }

    private List optimos() {
        List optimos = new List();
        // falta para floyd ocupo ayuda de aceite
        return optimos;
    }

}
