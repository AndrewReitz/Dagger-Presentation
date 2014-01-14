/**
 * @fileOverview
 * grunt commands for grunt-cli that will make your life better!
 *
 * @author Pieces029
 */
module.exports = function (grunt) {
    'use strict';

    grunt.initConfig({
        watch: {
            livereload: {
                files: ['src/index.html'],
                tasks: 'htmllint',
                options: {
                    livereload: true
                }
            }
        },
        connect: {
            server: {
                options: {
                    port: 8888,
                    base: 'src',
                    keepalive: true,
                    hostname: '127.0.0.1',
                    livereload: true
                }
            }
        },
        concurrent: {
            target: {
                tasks: ['connect', 'watch', 'open:connect'],
                options: {
                    logConcurrentOutput: true
                }
            }
        },
        open: {
            connect: {
                path: 'http://127.0.0.1:8888',
                app: 'google-chrome'
            },
            file: {
                path: 'src/index.html',
                app: 'google-chrome'
            },
            release: {
                path: 'http://pieces029.github.io/Dagger-Presentation',
                app: 'google-chrome'
            }
        },
        htmllint: {
            all: ["src/index.html"]
        },
        imagemin: {
            dynamic: {
                files: [
                    {
                        expand: true,
                        cwd: 'src/',
                        src: ['**/*.{png,jpg,gif}'],
                        dest: 'src/'
                    }
                ]
            }
        },
        clean: {
            build: [
                "dist/css",
                "dist/fonts",
                "dist/images",
                "dist/lib",
                "dist/index.html"
            ]
        },
        copy: {
            release: {
                expand: true,
                cwd: 'src/',
                src: '**',
                dest: 'dist/'
            },
            releaseReplace: {
                src: 'dist/index.html',
                dest: 'dist/index.html',
                options: {
                    process: function (content, srcpath) {
                        content = content.replace(
                            "{ src: 'lib/reveal.js/plugin/notes/notes.js', async: true, condition: function() { return !!document.body.classList; } },",
                            "{ src: 'lib/reveal.js/plugin/notes/notes.js', async: true, condition: function() { return !!document.body.classList; } }");

                        return content.replace(
                            "{ src: 'lib/reveal.js/plugin/remotes/remotes.js', async: true, condition: function() { return !!document.body.classList; } }",
                            ""
                        );
                    }
                }
            }
        },
        githubPages: {
            target: {
                options: {
                    // The default commit message for the gh-pages branch
                    commitMessage: 'pushing updates'
                },
                // The folder where your gh-pages repo is
                src: 'dist'
            }
        }
    });

    grunt.loadNpmTasks('grunt-contrib-watch');
    grunt.loadNpmTasks('grunt-contrib-connect');
    grunt.loadNpmTasks('grunt-contrib-imagemin');
    grunt.loadNpmTasks('grunt-contrib-copy');
    grunt.loadNpmTasks('grunt-contrib-clean');
    grunt.loadNpmTasks('grunt-github-pages');
    grunt.loadNpmTasks('grunt-concurrent');
    grunt.loadNpmTasks('grunt-open');
    grunt.loadNpmTasks('grunt-html');

    // Default task
    grunt.registerTask('default', ['help']);

    grunt.registerTask('help', 'Prints out the specific details of each command', function () {
        console.log("Available Commands");
        console.log("  watch:\tAuto pushes updates to the browser on save");
        console.log("  connect:\tStart a local server for testing on port 8888");
        console.log("  dev:\tRuns all dev commands, if your are developing you want this");
        console.log("  open:connect\tOpens Google Chrome to the index page on port 8888");
        console.log("  open:file\tOpens the html file in chrome");
        console.log("  open:release\tOpens the page in github pages");
        console.log("  imagemin\tOptimize your images for the web");
    });

    grunt.registerTask('dev', 'Runs all dev commands, if your are developing you want this', 'concurrent:target');

    grunt.registerTask('release', 'Creates the release build and publishes it to github pages',
        [
            'clean:build',
            'imagemin',
            'copy:release',
            'copy:releaseReplace',
            'deploy'
        ]
    );

    grunt.registerTask('deploy', ['githubPages:target']);
};
