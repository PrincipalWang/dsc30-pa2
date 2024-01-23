import java.util.ArrayList;
import utilities.FullStackException;



/*
 * NAME: Chen Wang
 * PID: A17090044
 */

/**
 * WebBrowser implementation
 *
 * @author Chen Wang
 * @since 1/22/2024
 */
public class WebBrowser {

    private String currentPage;
    private ArrayList<String> history;
    private MyStack prev;
    private MyStack next;

    private static final String DEFAULT_PAGE = "google.com";
    private static final int HUNDRED = 100;

    /**
     * empty constructor
     */
    public WebBrowser() {
        currentPage = DEFAULT_PAGE;
        history = new ArrayList<String>();
        prev = new MyStack(HUNDRED);
        next = new MyStack(HUNDRED);
    }

    /**
     * return current page
     *
     * @return current page
     */
    public String getCurrentPage() {
        return currentPage;
    }

    /**
     * open a new page
     *
     * @param newLink the new page
     */
    public void openNewPage(String newLink) {
        next.clear();
        prev.push(currentPage);
        history.add(newLink);
        currentPage = newLink;
    }

    /**
     * go to previous page
     *
     * @throws IllegalStateException if there is no previous page
     */
    public void previousPage() throws IllegalStateException{
        if(prev.isEmpty()){
            throw new IllegalStateException();
        }
        next.push(currentPage);
        currentPage=prev.pop();
        history.add(currentPage);
    }

    /**
     * go to next page
     *
     * @throws IllegalStateException if there is no next page
     */
    public void nextPage() throws IllegalStateException{
        if(next.isEmpty()){
            throw new IllegalStateException();
        }
        prev.push(currentPage);
        currentPage=next.pop();
        history.add(currentPage);
    }

    /**
     * open a new tab
     */
    public void newTab() {
        currentPage = DEFAULT_PAGE;
        prev.clear();
        next.clear();
    }

    /**
     * return history
     *
     * @return history
     */
    public ArrayList getHistory() {
        return history;
    }

    /**
     * clear the history
     */
    public void clearHistory() {
        history.clear();
    }

    /**
     * Search the history and if it contains the link, open a new page using this link
     * and return true. Otherwise, return false.
     *
     * @param link link to be searched
     * @return found or not
     */
    public boolean findLink(String link) {
        if(history.contains(link)){
            openNewPage(link);
            return true;
        }
        return false;
    }

}
