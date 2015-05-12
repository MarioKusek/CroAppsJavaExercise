package hr.fer.croapps;

import org.htmlcleaner.ContentNode;
import org.htmlcleaner.HtmlNode;
import org.htmlcleaner.TagNode;
import org.htmlcleaner.TagNodeVisitor;

import java.util.LinkedList;
import java.util.List;

public class HtmlTagVisitor implements TagNodeVisitor {
    private int trCount = 0;
    private int tdCount = 0;
    private ScheduleEntry currentEntry;
    private List<ScheduleEntry> list;

    public HtmlTagVisitor() {
        list = new LinkedList<ScheduleEntry>();
    }

    public boolean visit(TagNode tagNode, HtmlNode htmlNode) {
        if (htmlNode instanceof TagNode) {
            TagNode tag = (TagNode) htmlNode;

            handleTag(tag);
        } else if (htmlNode instanceof ContentNode) {
            handleText((ContentNode) htmlNode);
        }
        // tells visitor to continue traversing the DOM tree
        return true;
    }

    private void handleTag(TagNode tag) {
        if (tag.getName().equalsIgnoreCase("tr")) {
            trCount++;
            tdCount = 0;
        } else if (tag.getName().equalsIgnoreCase("td")) {
            tdCount++;
        }
    }

    private void handleText(ContentNode text) {
        String trimmedText = text.toString().trim();
        if (trimmedText.length() == 0)
            return;

        if ((trCount % 3) == 1) {

            if (tdCount == 1) {
                currentEntry = new ScheduleEntry();
                list.add(currentEntry);
                currentEntry.setRoom(trimmedText);
            } else if (tdCount == 2) {
                currentEntry.setTime(trimmedText);
            }

        } else if ((trCount % 3) == 2) {
            currentEntry.setTitle(trimmedText);
        }
    }

    public List<ScheduleEntry> getListofEntries() {
        return list;
    }

}
