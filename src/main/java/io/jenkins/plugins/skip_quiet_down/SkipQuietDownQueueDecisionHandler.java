package io.jenkins.plugins.skip_quiet_down;

import hudson.Extension;
import hudson.model.Action;
import hudson.model.Job;
import hudson.model.Queue;
import org.kohsuke.accmod.Restricted;
import org.kohsuke.accmod.restrictions.NoExternalUse;

import java.util.List;

@Restricted(NoExternalUse.class)
@Extension
public class SkipQuietDownQueueDecisionHandler extends Queue.QueueDecisionHandler {

    @Override
    public boolean shouldSchedule(Queue.Task p, List<Action> actions) {
        if (p instanceof Job && ((Job) p).getProperty(SkipQuietDownProperty.class) != null) {
            actions.add(new Queue.NonBlockingAction());
        }
        return true;
    }
}
