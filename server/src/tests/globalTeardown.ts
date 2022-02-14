export default async function () {
  await (global as any).app.close();
}
