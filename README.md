## Demo project for Composite Config Server

1. Create the config servers below
2. Push the app to CF
3. Observe app logs that it doesn't resolve propertis foo and bar
4. Bind to `single-cfg-a`
5. Restage app
6. Observe app logs only resolving property foo and not bar
7. Unbind from `single-cfg-a`
8. Bind to `single-cfg-b`
9. Restage app
10. Observe app logs only resolving property bar and not foo
11. Unbind from `single-cfg-b`
12. Bind to `composite-cfg`
13. Restage app
14. Observe app logs resolving both foo and bar

# Single repo config servers
`cf cs p.config-server standard single-cfg-a -c '{"git":{"uri": "https://github.com/NLxAROSA/composite-config-a", "periodic": true, "label":"main"}}'`
`cf cs p.config-server standard single-cfg-b -c '{"git":{"uri": "https://github.com/NLxAROSA/composite-config-b", "periodic": true, "label":"main"}}'`

# Composite repo config server
`cf cs p.config-server standard composite-cfg -c '{"composite":[{ "type": "git", "uri": "https://github.com/NLxAROSA/composite-config-a", "periodic": true, "label":"main"}, {"type": "git", "uri": "https://github.com/NLxAROSA/composite-config-b", "periodic": true, "label":"main"}]}'`