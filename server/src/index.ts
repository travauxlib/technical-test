import { buildFastify, start } from './app';

buildFastify().then((app) => start(app));
