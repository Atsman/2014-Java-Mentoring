window.APP = window.APP || {};

APP.LinkRouter = Backbone.Router.extend({
    routes: {
        "link/new": "create",
        "link/index": "index",
        "link/:id/edit": "edit",
        "link/:id/view": "show"
    },

    initialize: function(options) {
        this.links = options.links;
        this.index();
    },
    create: function() {
        this.currentView = new APP.LinkCreateView({
            links: this.links,
            link: new APP.LinkModel()
        });
        $('#primary-content').html(this.currentView.render());
    },
    edit: function(id) {
        var link = this.links.get(id);
        this.currentView = new APP.LinkEditView({
            link: link
        });
        $('#primary-content').html(this.currentView.render());
    },
    index: function() {
        this.currentView = new APP.LinkIndexView({
            links: this.links
        });
        $('#primary-content').html(this.currentView.render().el);
    }
});
