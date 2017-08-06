import java.util.ArrayList;
import java.util.List;

/**
 * Created by eig on 02/08/17.
 */
public class Node
{
    private char data;
    private List<Node> childs;

    public Node(char data)
    {
        this.data = data;
        this.childs = new ArrayList<Node>();
    }

    public char getData()
    {
        return data;
    }

    public void setData(char data)
    {
        this.data = data;
    }

    public List<Node> getChilds()
    {
        return childs;
    }

    public void addChild(Node child)
    {
        this.childs.add(child);
    }
}