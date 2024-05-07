package com.demo.portal.test.principle.demeter;

public class Boss implements Manager {

    private ProjectLeader projectLeader;

    public ProjectLeader getProjectLeader() {
        return projectLeader;
    }

    public void setProjectLeader(ProjectLeader projectLeader) {
        this.projectLeader = projectLeader;
    }

    @Override
    public void meet(Project project) {
        System.out.println("BOSS开会确定开发" + project.getClass().getSimpleName() + "项目, 分派给项目经理");
        projectLeader.meet(project);
    }
}
