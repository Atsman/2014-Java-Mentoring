APP.LinkIndexView = Backbone.View.extend({
    // the constructor
    initialize: function(options) {
        // model is passed through
        this.links = options.links;
        this.links.bind('reset', this.addAll, this);
    },
    // populate the html to the dom
    render: function() {
        this.$el.html($('#indexTemplate').html());
        this.addAll();
        return this;
    },
    addAll: function() {
        // clear out the container each time you render index
        this.$el.find('tbody').children().remove();
        _.each(this.links.models, $.proxy(this, 'addOne'));
    },
    addOne: function(link) {
        var view = new APP.LinkView({
            links: this.links,
            link: link
        });
        this.$el.find("tbody").append(view.render());
    }
});
