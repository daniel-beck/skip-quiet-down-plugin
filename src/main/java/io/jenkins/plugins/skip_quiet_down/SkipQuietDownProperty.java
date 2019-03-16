package io.jenkins.plugins.skip_quiet_down;

import hudson.Extension;
import hudson.model.Job;
import jenkins.model.OptionalJobProperty;
import org.kohsuke.accmod.Restricted;
import org.kohsuke.accmod.restrictions.NoExternalUse;
import org.kohsuke.stapler.DataBoundConstructor;

import org.jenkinsci.Symbol;

import javax.annotation.Nonnull;

@Restricted(NoExternalUse.class)
public class SkipQuietDownProperty extends OptionalJobProperty<Job<?, ?>> {

    @DataBoundConstructor
    public SkipQuietDownProperty() {
        // presence on the job is good enough
    }

    @Symbol("skipQuietDown")
    @Extension
    public static final class DescriptorImpl extends OptionalJobPropertyDescriptor {
        @Nonnull
        @Override
        public String getDisplayName() {
            return "Bypass Quiet Down mode blockage";
        }

        @Override
        public boolean isApplicable(Class<? extends Job> jobType) {
            //return !(Queue.NonBlockingTask.class.isAssignableFrom(jobType));
            return true;
        }
    }
}
